package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.controlboard.ControlBoard;



public class ShootCommand extends Command{
    private Shooter shooter;
    private ControlBoard control;
    private double targetRPM;
    private PIDController pidController = new PIDController(.1, 0, 0);

    public ShootCommand(ControlBoard control, Shooter shooter){
        this.shooter = shooter;
        this.control = control;
        pidController.setTolerance(10, 20);
        SmartDashboard.putData("ShooterRPM", pidController);

        addRequirements(shooter);
    }

    @Override
    public void execute() {
        //needs intake subsystem
        //runs the rear pulley after the RPM reaches a certain value to feed the ball into the shooter
        if (control.rightBumper()){
            targetRPM = 5000;
        }
        else {
            targetRPM = 0;
        }
        pidController.setSetpoint(targetRPM);
        double shooterRPM = shooter.getRPM();
        double output = pidController.calculate(shooterRPM);
        output = MathUtil.clamp(output, -14, 14);
        shooter.setSpeed(output);
    }

    @Override
    public void initialize() {
        pidController.setSetpoint(0);
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return pidController.atSetpoint() & pidController.getSetpoint() != 0;
    }


    
}
