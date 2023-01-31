
package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
public class MecanumBase extends SubsystemBase
{
    private CANSparkMax frontLeft = new CANSparkMax(4, MotorType.kBrushless);
    private CANSparkMax backLeft = new CANSparkMax(3, MotorType.kBrushless);
    private CANSparkMax frontRight = new CANSparkMax(2, MotorType.kBrushless);
    private CANSparkMax backRight = new CANSparkMax(5, MotorType.kBrushless);
    
    private MecanumDrive robot = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    public MecanumBase()
    {
        backRight.setInverted(true);
        frontRight.setInverted(true);
        
        // Constructor
    }
    @Override
    public void periodic()
    {
        //System.out.println(RobotContainer.getGryoYawAngle());
        //robot.driveCartesian(RobotContainer.getF(), RobotContainer.getS(), RobotContainer.getR(),RobotContainer.getGryoYawAngle());
        // This method will be called once per scheduler run
    }
    @Override
    public void simulationPeriodic()
    {
        // This method will be called once per scheduler run during simulation
    }

    public void drive()
    {
        robot.driveCartesian(RobotContainer.getF(), RobotContainer.getS(), RobotContainer.getR());
    }
    public double getVelocity(CANSparkMax motor)
    {
        double velocity = motor.getEncoder().getVelocity();
        return velocity;
    }
}

