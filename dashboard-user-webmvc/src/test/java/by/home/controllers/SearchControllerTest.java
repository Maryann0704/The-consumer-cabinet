package by.home.controllers;

import by.home.TestConfiguration;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ContextConfiguration(classes = TestConfiguration.class)
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class SearchControllerTest extends
        ScenarioTest<SearchControllerTest.Given,
                SearchControllerTest.When,
                SearchControllerTest.Then> {

    static class Given extends Stage<Given> {
        @ProvidedScenarioState
        String search;

        Given userEnterEmptySearchString(String searchStr) {
            search = searchStr;
            return self();
        }

        Given userEnterCorrectSearchString(String searchStr) {
            search = searchStr;
            return self();
        }
    }

    static class When extends Stage<When> {
        @ExpectedScenarioState
        String search;

        @ProvidedScenarioState
        ModelAndView modelAndView;

        When executeSearch(MockMvc mockMvc) throws Exception {
            modelAndView = mockMvc
                    .perform(get("/search").param("search-str", search))
                    .andReturn().getModelAndView();
            return when();
        }
    }

    static class Then extends Stage<Then> {
        @ExpectedScenarioState
        ModelAndView modelAndView;

        Then resultSizeIs(int size) {
            assertNotNull(modelAndView);
            assertEquals("searchResult", modelAndView.getViewName());
            assertTrue(modelAndView.getModel().containsKey("result"));
            List list = (List) modelAndView.getModel().get("result");
            assertEquals(size, list.size());
            return self();
        }
    }

    @Autowired
    private WebApplicationContext webApplicationContext;

    @ProvidedScenarioState
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void search() throws Exception {
        given().userEnterEmptySearchString("");
        when().executeSearch(mockMvc);
        then().resultSizeIs(0);
    }

    /*@Test
    @Sql(value = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "/test-data-delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void searchWithParam() throws Exception {
        given().userEnterCorrectSearchString("water");
        when().executeSearch(mockMvc);
        then().resultSizeIs(2);
    }*/
}