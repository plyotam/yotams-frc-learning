// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.lang.module.ModuleDescriptor.Requires;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.drivetrain;

public class DriveArcade extends CommandBase {
  /** Creates a new DriveArcade. */
  private drivetrain drivetrain;
  public DriveArcade() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.drivetrain);
  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftstickY = RobotContainer.getdriverrawaxis(Constants.leftsticky);
    double leftstickX = RobotContainer.getdriverrawaxis(Constants.leftstickx);//somethings janky about the robotcontainer class that makes this a error
    double leftPower =  (-leftstickY) - (-leftstickX);//better way is to make a new double for the inverted vals but im lazy
    double rightPower = (-leftstickY) + (-leftstickX);
    Robot.drivetrain.setleftdrive(leftPower);
    Robot.drivetrain.setrightdrive(rightPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.end(interrupted);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
