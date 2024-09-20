package frc.robot.commands;

import frc.robot.subsystems.REVMotorSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;

public class REVMotorCommand extends Command {
    private final REVMotorSubsystem r_REVMotor;
    private final DoubleSupplier speedSup;

    public REVMotorCommand(REVMotorSubsystem r_REVMotor, DoubleSupplier speedSup) {
        this.r_REVMotor = r_REVMotor;
        addRequirements(r_REVMotor);

        this.speedSup = speedSup;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        double r_Speed = speedSup.getAsDouble();
        r_REVMotor.setREVMotorSpeed(r_Speed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        r_REVMotor.brakeREVMotor(false);
    }
}