package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private CANSparkMax intake;
    private CANSparkMax frontPulley;
    private CANSparkMax rearPulley;

    public Intake(){
        initMotors(intake);
        initMotors(frontPulley);
        initMotors(rearPulley);

    }

    private void initMotors(CANSparkMax motor){
        motor.setSmartCurrentLimit(40);
        motor.setOpenLoopRampRate(20);
        motor.setIdleMode(IdleMode.kBrake);
    }

    public void setIntake(double intakeSpeed, double frontPulleySpeed, double rearPulleySpeed){
        this.intake.set(intakeSpeed);
        this.frontPulley.set(frontPulleySpeed);
        this.rearPulley.set(rearPulleySpeed);
    }

    @Override
    public void periodic() {
        //What is needed here if not using PID loop?
    }
}
