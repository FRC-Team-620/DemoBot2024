package frc.robot.controlboard;

//import org.jmhsrobotics.frc2024.Constants;

import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class SingleControl implements ControlBoard{
    private XboxController driver = new XboxController(0);


    //====Drivetrain====
    public double rightTrigger(){
        return driver.getRightTriggerAxis();
    }

    public double leftTrigger(){
        return driver.getLeftTriggerAxis();
    }

    public double rightX(){
        return driver.getRightX();
    }

    //====Other Subsystems====
    public boolean rightBumper(){
        return driver.getRightBumper();
    }

    public boolean leftBumper(){
        return driver.getLeftBumper();
    }
}
