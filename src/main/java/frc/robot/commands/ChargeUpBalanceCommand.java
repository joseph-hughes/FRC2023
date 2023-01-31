// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.MechanumDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class ChargeUpBalanceCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final MechanumDrive m_subsystem;
  boolean isFinished = false;
  boolean inErrorZone = false;
  int count;

  public ChargeUpBalanceCommand(MechanumDrive subsystem) {
    m_subsystem = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    if(m_subsystem.count >= 3){
        m_subsystem.startPID();
    }
  }

  @Override
  public void execute() {
    m_subsystem.PIDDrive();  
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}