package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    private Spark front = new Spark(Constants.INTAKE_FRONT_ID);
    private Spark back = new Spark(Constants.INTAKE_BACK_ID);
    private double speed;

    public Intake() {
        this.back.setInverted(true);
    }

    public void setSpeed(double speed) {
        this.front.set(speed);
        this.back.set(speed);
        this.speed = speed;
    }

    @Override
    public void periodic() {
        // SmartDashboard.putNumber("Intake/speed", this.speed);
    }
}
