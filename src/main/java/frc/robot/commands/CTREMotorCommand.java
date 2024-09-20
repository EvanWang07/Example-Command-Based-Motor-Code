package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import java.util.function.DoubleSupplier;

import frc.robot.subsystems.CTREMotorSubsystem;

public class CTREMotorCommand extends Command {
    private CTREMotorSubsystem m_CTREMotor;
    private DoubleSupplier m_speed;

    public CTREMotorCommand(CTREMotorSubsystem m_CTREMotor, DoubleSupplier m_speed) {
        this.m_CTREMotor = m_CTREMotor;
        addRequirements(m_CTREMotor);

        this.m_speed = m_speed;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        double motorSpeedInput = m_speed.getAsDouble();
        m_CTREMotor.setCTREMotorSpeed(motorSpeedInput);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_CTREMotor.brakeCTREMotor(false);
    }
}
