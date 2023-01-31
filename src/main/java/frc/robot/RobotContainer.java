// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private MecanumBase drive;
  private GyroResetCommand gyroReset;
  private static Joystick stick = new Joystick(0);
  private static AHRS gyro = new AHRS();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    drive= new MecanumBase();
    gyroReset=new GyroResetCommand();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(stick, 12).whileHeld(gyroReset);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
public static double getMotorSpeed() {
    //System.out.println(stick.getRawAxis(3));
    return (stick.getRawAxis(3)+1)/2;
    //return 0.30;
}

public static double getF() {
    return stick.getRawAxis(1)*getMotorSpeed();
}

public static double getS() {
    return -stick.getRawAxis(0)*getMotorSpeed();
}

public static double getR() {
    double sValue = stick.getRawAxis(2);
    if(sValue<0.1&&sValue>-0.1)
    {
      sValue=0;
    } 
    return sValue*getMotorSpeed();
}
public static Rotation2d getGryoYawAngle()
{
  
  return Rotation2d.fromDegrees(gyro.getAngle());
}

public static void resetGyro() {
  gyro.zeroYaw();
}

}
