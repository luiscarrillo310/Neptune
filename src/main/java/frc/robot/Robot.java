package frc.robot;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
// Construction of framework for code
  private CANSparkMax m_leftFront;
  private CANSparkMax m_leftAft;
  private CANSparkMax m_rightFront;
  private CANSparkMax m_rightAft;

  private SpeedControllerGroup m_left;
  private SpeedControllerGroup m_right;

}
