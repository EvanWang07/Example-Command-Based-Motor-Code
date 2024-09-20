package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class REVMotorSubsystem extends SubsystemBase {
    private final CANSparkMax revMotor;

    public REVMotorSubsystem() {
        revMotor = new CANSparkMax(Constants.MotorConstants.REV.revMotorID, MotorType.kBrushless);

        new Thread(() -> {
            try {
                Thread.sleep(Constants.QuickChangeConstants.StartupConstants.robotStartupTime);
                revMotor.setInverted(Constants.MotorConstants.REV.revMotorInverted);
            } catch (Exception e) {
            }
        }).start();
    }

    public void setREVMotorSpeed(double speed) {
        revMotor.set(speed * Constants.MotorConstants.REV.revMotorOutput);
    }

    public void brakeREVMotor(boolean useBrakeMode) {
        if (useBrakeMode) {
            revMotor.setIdleMode(IdleMode.kBrake);
        } else {
            revMotor.setIdleMode(IdleMode.kCoast);
        }
    }

    @Override
    public void periodic() {
        
    }
}
