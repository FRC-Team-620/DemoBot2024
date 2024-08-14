package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PrestonSubsystem extends SubsystemBase {
    private CANSparkMax motor = new CANSparkMax(10, MotorType.kBrushless);

    public PrestonSubsystem() {
        motor.setOpenLoopRampRate(20);
        motor.setIdleMode(IdleMode.kBrake);
        motor.setSmartCurrentLimit(40);
    }

    public void setSpeed(Double RPM){
        this.motor.set(RPM);
    }
}
