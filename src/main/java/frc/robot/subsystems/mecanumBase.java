
package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
public class MecanumBase extends SubsystemBase
{
    public CANSparkMax frontLeft = new CANSparkMax(5, MotorType.kBrushless);
    public CANSparkMax backLeft = new CANSparkMax(2, MotorType.kBrushless);
    public CANSparkMax frontRight = new CANSparkMax(3, MotorType.kBrushless);
    public CANSparkMax backRight = new CANSparkMax(4, MotorType.kBrushless);
    
    private MecanumDrive robot = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    public MecanumBase()
    {
        // Constructor
    }
    @Override
    public void periodic()
    {
        robot.driveCartesian(RobotContainer.getX(), RobotContainer.getY(), RobotContainer.getR());
        // This method will be called once per scheduler run
    }
    @Override
    public void simulationPeriodic()
    {
        // This method will be called once per scheduler run during simulation
    }

    public void drive()
    {
        robot.driveCartesian(RobotContainer.getX(), RobotContainer.getY(), RobotContainer.getR());
    }
    public double getVelocity(CANSparkMax motor)
    {
        double velocity = motor.getEncoder().getVelocity();
        return velocity;
    }
}

