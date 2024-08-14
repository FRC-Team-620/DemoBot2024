package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AndrewSubsystem extends SubsystemBase{
    private CANSparkMax shooterMotor = new CANSparkMax(10, MotorType.kBrushless);
    private CANSparkMax motor;

    public AndrewSubsystem(){

        motor.setOpenLoopRampRate(10);
        motor.setIdleMode(IdleMode.kBrake);
        motor.setSmartCurrentLimit(20);
    }

    public void setSpeed (double RPM){

        this.motor.set(RPM);
    }

}
