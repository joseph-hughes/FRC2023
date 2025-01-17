package frc.robot.subsystems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;

public class Vision extends SubsystemBase {
  private PhotonCamera limelight;

  // Constants such as camera and target height stored. Change per robot and goal!

  final double CAMERA_HEIGHT_METERS = Units.inchesToMeters(24);

  final double TARGET_HEIGHT_METERS = Units.feetToMeters(5);

  // Angle between horizontal and the camera.

  final double CAMERA_PITCH_RADIANS = Units.degreesToRadians(0);

  // Pipeline mode.
  public static final String kLimelightPipelineKey = "limelight-pipeline";

  public Vision() {
    // Stuff goes here
    limelight = new PhotonCamera("limelight");

    // Set default pipeline
    if (!Preferences.containsKey(kLimelightPipelineKey)) {
      Preferences.setInt(kLimelightPipelineKey, 1); // Default to tape
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    var result = limelight.getLatestResult();
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  /**
   * Get the latest pipeline result.
   *
   * @return The latest pipeline result.
   */
  public PhotonPipelineResult getLatestResult() {
    return limelight.getLatestResult();
  }

  /**
   * Change the Limelight pipeline.
   *
   * @param pipeline The pipeline to change to.
   */
  public void changePipeline(int pipeline) {
    limelight.setPipelineIndex(pipeline); // As of now, 1 is tape, 2 is tag
    Preferences.setInt(
        kLimelightPipelineKey,
        pipeline); // Save the pipeline index to preferences so we know what we're doing
  }
}
