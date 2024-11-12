package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private CANSparkMax intakeMotor1 = new CANSparkMax(6,MotorType.kBrushed);
    private CANSparkMax intakeMotor2 = new CANSparkMax(7,MotorType.kBrushed);

    public Intake(){
        initMotor(intakeMotor1);
        initMotor(intakeMotor2);

    }

    private void initMotor(CANSparkMax motor){
        motor.setOpenLoopRampRate(20);
        motor.setIdleMode(IdleMode.kBrake);
        motor.setSmartCurrentLimit(40);
    }

    public void setSpeed(double voltage){
        this.intakeMotor1.setVoltage(voltage);
        this.intakeMotor2.setVoltage(voltage*-1);


    }


}
