// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExtakeCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.controlboard.ControlBoard;
import frc.robot.controlboard.SingleControl;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    public final ControlBoard control;
    private final Drivetrain drivetrain;
    private final Intake intake;
    private final Shooter shooter;

    private final DriveCommand driveCommand;
    private final IntakeCommand intakeCommand;
    private final ExtakeCommand extakeCommand;
    private final ShootCommand shootCommand;

    public RobotContainer() {
        this.control = new SingleControl();
        this.drivetrain = new Drivetrain();
        this.intake = new Intake();
        this.shooter = new Shooter();

        this.driveCommand = new DriveCommand(this.drivetrain, this.control);
        this.intakeCommand = new IntakeCommand(this.intake);
        this.extakeCommand = new ExtakeCommand(this.intake);
        this.shootCommand = new ShootCommand(this.shooter);

        drivetrain.setDefaultCommand(this.driveCommand);

        configureBindings();
    }

    /**
     * Use this method to define your trigger->command mappings. Triggers can be
     * created via the
     * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
     * an arbitrary
     * predicate, or via the named factories in {@link
     * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
     * {@link
     * CommandXboxController
     * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
     * PS4} controllers or
     * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
     * joysticks}.
     */
    private void configureBindings() {
        this.control.intake().whileTrue(intakeCommand);
        this.control.extake().whileTrue(extakeCommand);
        this.control.shoot().whileTrue(shootCommand);
    }
}
