package guru.springframework.controllers;

import guru.springframework.services.RecipeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class IndexControllerTest {

    private IndexController controller;

    @Mock
    private RecipeServiceImpl recipeService;
    @Mock
    private Model model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {
        String viewName = controller.getIndexPage(model);

        Assert.assertEquals("index", viewName);
        Mockito.verify(recipeService, Mockito.times(1))
               .getRecipes();
        Mockito.verify(model, Mockito.times(1))
               .addAttribute(ArgumentMatchers.eq("recipes"), ArgumentMatchers.anySet());
    }
}
