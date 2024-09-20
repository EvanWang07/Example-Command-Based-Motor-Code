// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.QuickChangeConstants.OperatorConstants;

import frc.robot.subsystems.CTREMotorSubsystem;
import frc.robot.subsystems.REVMotorSubsystem;

import frc.robot.commands.CTREMotorCommand;
import frc.robot.commands.REVMotorCommand;
import frc.robot.commands.TimedAutoMotorCommand;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class RobotContainer {
  /* Controllers */
  private final Joystick controllerOne = new Joystick(OperatorConstants.controllerOnePort);
  
  /* Controls */
  private final int c_CTREMovementAxis = XboxController.Axis.kLeftY.value;
  private final int c_REVMovementAxis = XboxController.Axis.kRightY.value;
  
  /* Subsystems */
  private final CTREMotorSubsystem c_CTREMotorSubsystem = new CTREMotorSubsystem();
  private final REVMotorSubsystem r_REVMotorSubsystem = new REVMotorSubsystem();

  public RobotContainer() {
    
    c_CTREMotorSubsystem.setDefaultCommand(
      new CTREMotorCommand(
        c_CTREMotorSubsystem,
        () -> controllerOne.getRawAxis(c_CTREMovementAxis)
      )
    );

    r_REVMotorSubsystem.setDefaultCommand(
      new REVMotorCommand(
        r_REVMotorSubsystem,
        () -> -controllerOne.getRawAxis(c_REVMovementAxis)
      )
    );
    configureBindings();

  }

  private void configureBindings() {

  }

  public Command getAutonomousCommand() {
    return new TimedAutoMotorCommand(c_CTREMotorSubsystem, r_REVMotorSubsystem);
  }
}
