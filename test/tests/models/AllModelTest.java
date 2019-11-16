package tests.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CoordinateTest.class,
    PieceTest.class,
    GameTest.class,
    GameWithDraughtsTest.class})
public final class AllModelTest {
}
