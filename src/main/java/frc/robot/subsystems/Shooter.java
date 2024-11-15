package frc.robot.subsystems;

// import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private Spark motor = new Spark(5);
    private Spark follower = new Spark(6);
    private double speed;

    public Shooter() {
        this.motor.addFollower(follower);
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
