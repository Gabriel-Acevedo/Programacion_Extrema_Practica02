package tests.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CoordinateTest.class,
    GameTest.class,
    GameWithDraughtsTest.class,
    PawnTest.class,
    DraughtTest.class,
})
public final class AllModelTest {
}
