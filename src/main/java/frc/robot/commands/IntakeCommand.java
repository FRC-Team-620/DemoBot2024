package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class IntakeCommand extends Command {
    private Intake intake;
    private boolean movingForward;

    public IntakeCommand(Intake intake, boolean movingForward) {
        this.intake = intake;
        this.movingForward = movingForward;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        double direction = movingForward ? 1.0 : -1.0;
        this.intake.setSpeed(direction * Constants.INTAKE_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        this.intake.setSpeed(0);
    }
}
