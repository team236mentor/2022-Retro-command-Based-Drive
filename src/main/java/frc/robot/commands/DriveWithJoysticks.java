/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class DriveWithJoysticks extends CommandBase {

  private Drive drive;
  private Joystick leftStick, rightStick;
  /**
   * Creates a new DriveWithJoysticks.
   */
  public DriveWithJoysticks(Drive drive, Joystick leftStick, Joystick rightStick, boolean isCube) {

    this.drive = drive;
    this.leftStick = leftStick;
    this.rightStick = rightStick;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Sets each side of robots speeds to correspond to joystick Y-axis
    drive.setLeftSpeed(-leftStick.getY());
    drive.setRightSpeed(-rightStick.getY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stops robot when command to drive ends
    drive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
