package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import java.text.SimpleDateFormat;

public class Robot extends TimedRobot {
    // Construction of framework for code
    private WPI_VictorSPX m_leftFront;
    private WPI_VictorSPX m_leftAft;
    private WPI_VictorSPX m_rightFront;
    private WPI_VictorSPX m_rightAft;

    private Joystick m_joy;

    private StringBuilder _sb = new StringBuilder();
    private int looperCounter = 0;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm:ss");

public void robotInit() {

    StringBuilder _initSb = new StringBuilder();

    m_leftFront = new WPI_VictorSPX(0);
    m_leftAft = new WPI_VictorSPX (1);
    m_rightFront = new WPI_VictorSPX (2);
    m_rightAft = new WPI_VictorSPX(3);
    }
}
