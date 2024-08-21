package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Shooter extends SubsystemBase{
    private CANSparkMax shooterMotor = new CANSparkMax(5, MotorType.kBrushless);
    private RelativeEncoder relativeEncoder;
    // maybe we should try to use a bangbang or a simple pid control
    public Shooter(){
        this.shooterMotor.setOpenLoopRampRate(0);
        this.shooterMotor.setIdleMode(IdleMode.kCoast);
        this.shooterMotor.setSmartCurrentLimit(40);

        this.relativeEncoder = this.shooterMotor.getEncoder();
    }

    public double getRPM(){
        return this.relativeEncoder.getVelocity();
    }

    public void setSpeed(double voltage){
        this.shooterMotor.setVoltage(voltage);
    }

    @Override
    public void periodic() {
        //what is needed?
        //maybe post some important values to the smart dash???
    }
}
 