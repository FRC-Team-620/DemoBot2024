package frc.robot.subsystems;

import com.playingwithfusion.TimeOfFlight;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.units.Time;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private CANSparkMax intake = new CANSparkMax(6, MotorType.kBrushless);
    private CANSparkMax frontPulley = new CANSparkMax(7, MotorType.kBrushless);
    private CANSparkMax rearPulley = new CANSparkMax(8, MotorType.kBrushless);
    private TimeOfFlight frontToF = new TimeOfFlight(1);
    private TimeOfFlight rearToF = new TimeOfFlight(2);

    public Intake(){
        initMotors(this.intake);
        initMotors(this.frontPulley);
        initMotors(this.rearPulley);
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

    public boolean getFrontToF(){
        return this.frontToF.getRange() < 100;
    }

    public boolean getRearToF(){
        return this.rearToF.getRange() < 100;
    }

    @Override
    public void periodic() {
        //What is needed here if not using PID loop?
        SmartDashboard.putBoolean("Intake/frontToF", this.getFrontToF());
        SmartDashboard.putBoolean("Intake/rearToF", this.getRearToF());
    }
}
