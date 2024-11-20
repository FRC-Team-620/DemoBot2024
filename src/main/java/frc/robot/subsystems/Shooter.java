package frc.robot.subsystems;

// import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private Spark motor = new Spark(Constants.SHOOTER_LEFT_ID);
    private Spark follower = new Spark(Constants.SHOOTER_RIGHT_ID);
    private double speed;

    public Shooter() {
        this.motor.addFollower(follower);
        this.follower.setInverted(true);
    }

    public void setSpeed(double speed) {
        this.motor.setVoltage(speed);
        this.speed = speed;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("ShooterSpeed", this.speed);
    }
}
