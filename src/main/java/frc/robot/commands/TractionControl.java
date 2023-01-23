package frc.robot.commands;

import frc.robot.subsystems.MecanumBase;
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
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
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
