package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.MecanumBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TractionControl extends CommandBase {
  private final MecanumBase m_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TractionControl(MecanumBase subsystem) {
    m_subsystem = subsystem;
    
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    double frontLeft = m_subsystem.frontLeft.getEncoder().getVelocity();
    double frontRight = m_subsystem.frontRight.getEncoder().getVelocity();
    double rearLeft = m_subsystem.rearLeft.getEncoder().getVelocity();
    double rearRight = m_subsystem.rearRight.getEncoder().getVelocity();

    WheelSpeeds expectedSpeeds;

    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Get velocity of each motor
    double frontLeft = m_subsystem.frontLeft.getEncoder().getVelocity();
    double frontRight = m_subsystem.frontRight.getEncoder().getVelocity();
    double rearLeft = m_subsystem.rearLeft.getEncoder().getVelocity();
    double rearRight = m_subsystem.rearRight.getEncoder().getVelocity();

    // Calculate the expected normalized voltage for each motor.
    MecanumDrive.WheelSpeeds expectedSpeeds = MecanumDrive.driveCartesianIK(
      RobotContainer.getX(), 
      RobotContainer.getY(), 
      RobotContainer.getR());
    
    double frontLeftExpected = expectedSpeeds.frontLeft;
    double frontRightExpected = expectedSpeeds.frontRight;
    double rearLeftExpected = expectedSpeeds.rearLeft;
    double rearRightExpected = expectedSpeeds.rearRight;

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
