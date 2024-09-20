package frc.robot;

public final class Constants {

  public static final class QuickChangeConstants {

    public static final class OperatorConstants {
      public static final int controllerOnePort = 0;
    }

    public static final class StartupConstants {
      public static final long robotStartupTime = 1000;
    }

  }

  public static final class MotorConstants {

    public static final class REV {
      public static final int revMotorID = 1;
      public static final boolean revMotorInverted = false;
      public static final double revMotorOutput = 0.1;
    }

    public static final class CTRE {
      public static final int ctreMotorID = 2;
      public static final boolean ctreMotorInverted = false;
      public static final double ctreMotorOutput = 0.1;
    }

  }

}
