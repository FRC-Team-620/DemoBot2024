package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class ExtakeCommand extends Command {
    private Intake intake;

    public ExtakeCommand(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        this.intake.setSpeed(-Constants.INTAKE_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        this.intake.setSpeed(0);
    }
}
