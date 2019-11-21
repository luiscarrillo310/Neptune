package frc.robot;

import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;

public class Robot extends TimedRobot {
    // Construction of framework for code
    private WPI_VictorSPX m_leftFront;
    private WPI_VictorSPX m_leftAft;
    private WPI_VictorSPX m_rightFront;
    private WPI_VictorSPX m_rightAft;

    private BaseMotorController m_left;
    private BaseMotorController m_right;
    private DifferentialDrive m_drive;

    private Joystick m_joy1;
    private Joystick m_joy2;

    private StringBuilder _sb = new StringBuilder();
    private int looperCounter = 0;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm:ss");

@Override
public void robotInit() {

    StringBuilder _initSb = new StringBuilder();

    m_leftFront = new WPI_VictorSPX(1);
    m_leftAft = new WPI_VictorSPX (2);
    m_rightFront = new WPI_VictorSPX(3);
    m_rightAft = new WPI_VictorSPX(4);

    m_leftAft.configFactoryDefault();
    m_leftFront.configFactoryDefault();
    m_rightAft.configFactoryDefault();
    m_rightFront.configFactoryDefault();

    File file = new
    File(Robot.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    _initSb.append("ROBOT.JAVA LAST REVISED;").append(sdf.format(file.lastModified()));

    _initSb.append("\n-----\nLEFt FRONT DRIVETRAIN FIRM;").append(m_leftFront.getFirmwareVersion());
    _initSb.append("\nLEFT AfT DRIVERTRAIN FIRM:").append(m_leftAft.getFirmwareVersion());
    _initSb.append("\nRIGHT FRONT DRIVETRAIN FIRM;:").append(m_rightFront.getFirmwareVersion());
    _initSb.append("\nRIGHT AFT DRIVETRAIN FIRM:").append(m_rightAft.getFirmwareVersion());

    System.out.println(_initSb);
    }

@Override
public void autonomousPeriodic() {

    teleopPeriodic();

    }

@Override
public void teleopPeriodic() {
    Shuffleboard.getTab("DRIVETRAIN").add(m_drive);
    m_drive.tankDrive(-m_joy1.getY(), m_joy1.getX());
    m_drive.tankDrive(-m_joy2.getY(), m_joy2.getX());

    looperCounter++;
    if (looperCounter >= 10) { printStats(); looperCounter = 0; }
}
private void printStats() {
    _sb.append("**********");
    _sb.append("\ntimestamp").append(sdf.format(Instant.now().getEpochSecond()));
    _sb.append("\tleft-front").append(m_leftFront.get());
    _sb.append("\tright-front").append(m_rightFront.get());
    _sb.append("\tleft-aft").append(m_leftAft.get());
    _sb.append("\tright-aft").append(m_rightAft.get());
    _sb.append("\n**********");

    System.out.println(_sb.toString());

    }
}
