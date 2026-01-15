package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private PowerDistribution pdp;
    private Spark motor = new Spark(Constants.SHOOTER_LEFT_ID);
    private Spark follower = new Spark(Constants.SHOOTER_RIGHT_ID);
    private double speed;

    public Shooter(PowerDistribution pdp) {
        this.pdp = pdp;
        this.motor.setInverted(false);
        this.motor.addFollower(follower);
    }

    public void setSpeed(double speed) {
        this.motor.set(speed);
        this.speed = speed;
    }

    @Override
    public void periodic() {
        // SmartDashboard.putNumber("Shooter/speed", this.speed);
        SmartDashboard.putNumber("Shooter/left_amps", this.pdp.getCurrent(1));
        SmartDashboard.putNumber("Shooter/right_amps", this.pdp.getCurrent(2));
    }
}
