// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */
  private static drivetrain drivetrain;
  private TalonFX motorleft1 ;
  private TalonFX motorleft2; 
  private TalonFX motorright1;
  private TalonFX motorright2;

  public drivetrain() {
    motorleft1 = new TalonFX(Constants.motorleft1_id);
    motorleft2 = new TalonFX(Constants.motorleft1_id);
    motorright1 = new TalonFX(Constants.motorleft1_id);
    motorright2 = new TalonFX(Constants.motorleft1_id);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setleftdrive(double speed){//donk think that i need follower mode 
    motorleft1.set(ControlMode.PercentOutput, speed);
    motorleft2.set(ControlMode.PercentOutput, speed);
  }
  public void setrightdrive(double speed){//i could set motors to inverted but it is simpler to multiply the speed by -1
    motorright1.set(ControlMode.PercentOutput, -speed);
    motorright2.set(ControlMode.PercentOutput, -speed);
  }
  public static drivetrain getinstance(){
    if (drivetrain == null){
      drivetrain = new drivetrain();
    }
    return drivetrain;

  }
}
