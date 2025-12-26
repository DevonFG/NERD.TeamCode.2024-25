import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotHardware;

@TeleOp(name="AdvancedDriveCode", group="9044.NERD.")
public class AdvancedDriveCode extends LinearOpMode {
  
    @Override
    public void runOpMode() {
        
        RobotHardware robot = new RobotHardware(this);
        robot.init();
        telemetry.addData(">", "Hardware Initialized");
        telemetry.update();
  
        waitForStart();
        //runtime.reset();
        
        double drive;
        double strafe;
        double turn;
        String power;
        String buttonsMode = "Fingers";
        double deadZone = .2;
        
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
          
            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            drive    = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value - Forward and Backward 
            strafe   =  gamepad1.left_stick_x;  // Strafe - Left and Right - taking move right as positive
            turn     =  gamepad1.right_stick_x;  // Rotation - ClockWise and CounterClockWise - taking turn right as positive
            
            robot.driveRobot(drive, strafe, turn);
            
            if (gamepad2.start) {
                if (buttonsMode == "Fingers") {
                    buttonsMode = "ScrewBrush";
                    // add code to switch light color - Yellow
                } else if (buttonsMode == "ScrewBrush") {
                    buttonsMode = "Fingers";
                    // add code to switch light color - Green
                } else {
                    telemetry.addData("Mode Unknown SWAP ERROR", null);
                    telemetry.update();
                    // add code to switch light color - Flash Both
                }
            }

            if (gamepad2.a) {
              if (buttonsMode == "Fingers") {
                buttonsMode = "ScrewBrush";
              } else if (buttonsMode == "ScrewBrush") {
                buttonsMode = "Fingers";
              } else {
                telemetry.addData("Mode Unknown BUTTON ERROR", null);
                telemetry.update();
                // add code to flash both light colors
            }
            
            if (buttonsMode == "ScrewBrush"){ 
              if (gamepad2.b) {
                robot.toggleScrewTurn("off");
              } 
              if (gamepad2.y) {
                robot.toggleScrewTurn("normal");
              }
              if (gamepad2.x) {
                robot.toggleScrewTurn("inverse");
              }
            }
            
            if (buttonsMode == "Fingers"){ 
              if (gamepad2.b) {
                robot.toggleFingers("off");
              } 
              if (gamepad2.y) {
                robot.toggleFingers("normal");
              }
              if (gamepad2.x) {
                robot.toggleFingers("inverse");
              }
            }

            if (gamepad1.y) {
              robot.toggleFingers("off");
            }
              
            if (gamepad1.x) {
              robot.toggleScrewTurn("off");
            }

            if (gamepad1.dpad_up) {
             robot.standUp("FullUp");
            }
              
            if (gamepad1.dpad_down) {
              robot.standUp("RestFromFull");
            }

            if (gamepad1.dpad_left) {
              robot.standUp("LowBasketUp");
            }

            if (gamepad1.dpad_right) {
              robot.standUp("RestFromLow");
            }

            if (gamepad1.left_trigger > deadZone) {
              robot.standUp(gamepad1.left_trigger);
            }

            if (gamepad1.right_trigger > deadZone) {
              robot.standUp(-gamepad1.right_trigger);
            }

            if (gamepad2.left_bumper){
              robot.armExpand();
            }

            if (gamepad2.right_trigger > deadZone){
              
            }
            
            // buttons coded: driving joysticks, swap, Screw brush and fingers spin.
            // buttons to be coded: 
            // CONTROLLER 2
            // arch screw controls - dpad
            // arm forward backward - bumpers
            // door open - right trigger
            // code for modes that swap - a, b, y
            // manual screw controls - left joystick
            // CONTROLLER 1
            //stand up/down controls - dpad
            // stand up/down manual mode - triggers
            // finger off - y
            // brush off - x
            
        }
    
    }
    
}
}
