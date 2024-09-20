package frc.robot.commands;

import frc.robot.Time;

import frc.robot.subsystems.CTREMotorSubsystem;
import frc.robot.subsystems.REVMotorSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

public class TimedAutoMotorCommand extends Command {
    private CTREMotorSubsystem m_CTREMotor;
    private REVMotorSubsystem m_REVMotor;
    private Time t_Timer;

    public TimedAutoMotorCommand(CTREMotorSubsystem m_CTREMotor, REVMotorSubsystem m_REVMotor) {
        this.m_CTREMotor = m_CTREMotor;
        addRequirements(m_CTREMotor);
        this.m_REVMotor = m_REVMotor;
        addRequirements(m_REVMotor);

        t_Timer = new Time();
    }

    @Override
    public void initialize() {
        t_Timer.resetTimer();
    }

    @Override
    public void execute() {
        m_CTREMotor.setCTREMotorSpeed(1);
        m_REVMotor.setREVMotorSpeed(1);
    }
    
    @Override
    public boolean isFinished() {
        if (t_Timer.getTime() >= 10.0) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void end(boolean interrupted) {
        m_CTREMotor.brakeCTREMotor(false);
        m_REVMotor.brakeREVMotor(false);
    }
}
