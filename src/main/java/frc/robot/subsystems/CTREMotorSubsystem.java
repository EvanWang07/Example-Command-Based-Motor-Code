package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class CTREMotorSubsystem extends SubsystemBase {
    private final TalonFX ctreMotor;

    public CTREMotorSubsystem() {
        ctreMotor = new TalonFX(Constants.MotorConstants.CTRE.ctreMotorID);

        new Thread(() -> {
            try {
                Thread.sleep(Constants.QuickChangeConstants.StartupConstants.robotStartupTime);
                ctreMotor.setInverted(Constants.MotorConstants.CTRE.ctreMotorInverted);
            } catch (Exception e) {
            }
        }).start();
    }

    public void setCTREMotorSpeed(double speed) {
        ctreMotor.set(speed * Constants.MotorConstants.CTRE.ctreMotorOutput);
    }

    public void brakeCTREMotor(boolean useBrakeMode) {
        if (useBrakeMode) {
            ctreMotor.setNeutralMode(NeutralModeValue.Brake);
        } else {
            ctreMotor.setNeutralMode(NeutralModeValue.Coast);
        }
    }

    @Override
    public void periodic() {

    }
}
