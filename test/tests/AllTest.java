package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.controllers.AllControllerTest;
import tests.models.AllModelTest;
import tests.views.AllViewTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AllModelTest.class,
    AllControllerTest.class,
    AllViewTest.class})
public final class AllTest {
}
