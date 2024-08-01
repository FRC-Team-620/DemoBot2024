package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    private CANSparkMax shooterMotor;
    private RelativeEncoder relativeEncoder;

    public Shooter(){
        this.shooterMotor.setOpenLoopRampRate(20);
        this.shooterMotor.setIdleMode(IdleMode.kCoast);
        this.shooterMotor.setSmartCurrentLimit(40);

        this.relativeEncoder = this.shooterMotor.getEncoder();
    }

    public double getShooterRPM(){
        return this.relativeEncoder.getVelocity();
    }

    public void setSpeed(int RPM){
        this.shooterMotor.set(RPM);
    }

    @Override
    public void periodic() {
        //what is needed?
    }
}
 