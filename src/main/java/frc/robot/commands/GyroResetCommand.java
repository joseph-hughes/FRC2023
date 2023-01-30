package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class GyroResetCommand extends CommandBase
{
   
    public GyroResetCommand()
    {
        
    }
    @Override
    public void initialize()
    {
        RobotContainer.resetGyro();
    }
    @Override
    public void execute()
    {
    }
    @Override
    public void end(boolean interrupted)
    {
    }
    @Override
    public boolean isFinished()
    {
        return true;
    }
}