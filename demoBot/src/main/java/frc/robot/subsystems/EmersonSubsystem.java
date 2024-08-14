package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class EmersonSubsystem extends SubsystemBase{
    private CANSparkMax motor = new CANSparkMax(10, MotorType.kBrushless);
    
    public EmersonSubsystem() {

    motor.setOpenLoopRampRate(10);
    motor.setIdleMode(IdleMode.kBrake);
    motor.setSmartCurrentLimit(20);
}

    public void setSpeed(Double RPM){
        this.motor.set(RPM);


    }
}

