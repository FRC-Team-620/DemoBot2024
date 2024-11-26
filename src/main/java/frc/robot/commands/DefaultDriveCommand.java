package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.controlboard.ControlBoard;
import frc.robot.subsystems.Drivetrain;

public class DefaultDriveCommand extends Command {
    private Drivetrain drivetrain;
    private final ControlBoard control;
    private boolean squareInputs;

    public DefaultDriveCommand(Drivetrain drivetrain, ControlBoard control) {
        this.drivetrain = drivetrain;
        this.control = control;
        addRequirements(this.drivetrain);

        this.squareInputs = Constants.SQUARE_INPUTS;
        SmartDashboard.putBoolean("Drivetrain/square_inputs", this.squareInputs);
    }

    @Override
    public void execute() {
        this.squareInputs = SmartDashboard.getBoolean("Drivetrain/square_inputs", this.squareInputs);
        double power = this.squareInputs ? 2 : 1;
        double forward = this.control.forward();
        double backward = this.control.backward();
        double speed = forward >= backward ? forward : -backward;
        speed = Math.signum(speed) * Math.pow(speed, power);

        drivetrain.setCurvatureDrive(speed, this.control.rotate(), true);
    }
}
