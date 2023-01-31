package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;



/** */
public class Drivebase extends SubsystemBase {

  public CANSparkMax lFront;
  public CANSparkMax lRear;
  private MotorControllerGroup left;
  private CANSparkMax rFront;
  private CANSparkMax rRear;
  private MotorControllerGroup right;
  private DifferentialDrive drive;


  /** */
  public Drivebase() {

    lFront = new CANSparkMax(4, MotorType.kBrushless);

    lFront.restoreFactoryDefaults();
    lFront.setInverted(false);
    lFront.setIdleMode(IdleMode.kCoast);
    lFront.burnFlash();

    lRear = new CANSparkMax(14, MotorType.kBrushless);

    lRear.restoreFactoryDefaults();
    lRear.setInverted(false);
    lRear.setIdleMode(IdleMode.kCoast);
    lRear.burnFlash();

    left = new MotorControllerGroup(lFront, lRear);
    addChild("Left", left);

    rFront = new CANSparkMax(2, MotorType.kBrushless);

    rFront.restoreFactoryDefaults();
    rFront.setInverted(false);
    rFront.setIdleMode(IdleMode.kCoast);
    rFront.burnFlash();

    rRear = new CANSparkMax(13, MotorType.kBrushless);

    rRear.restoreFactoryDefaults();
    rRear.setInverted(false);
    rRear.setIdleMode(IdleMode.kCoast);
    rRear.burnFlash();

    right = new MotorControllerGroup(rFront, rRear);
    addChild("Right", right);

    drive = new DifferentialDrive(left, right);
    addChild("Drive", drive);
    drive.setSafetyEnabled(true);
    drive.setExpiration(0.1);
    drive.setMaxOutput(1.0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run when in simulation

  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  
  /**
   * Drives the robot using arcade drive.
   *
   * @param speed The forward/backward speed.
   * @param rotation The rotation speed.
   */
  public void arcadeDrive(double speed, double rotation) {
      left.setInverted(Constants.Drivebase.Left.IsInverted);
      right.setInverted(Constants.Drivebase.Right.IsInverted);
      drive.arcadeDrive(speed, rotation);
  }
}
