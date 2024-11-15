package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private Spark motor1 = new Spark(6);
    private Spark motor2 = new Spark(7);
    private double speed;

    public Intake() {
        this.motor2.setInverted(true);
    }

    public void setSpeed(double speed) {
        this.motor1.set(speed);
        this.motor2.set(speed);
        this.speed = speed;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("ShooterSpeed", this.speed);
    }
}
