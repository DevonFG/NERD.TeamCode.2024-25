import org.firstinspires.ftc.teamcode.HardwareFile2024;
import org.firstinspires.ftc.teamcode.AutonomousHardware;
@Autonomous(name="RightSideBasicAutonomous", group="9044.NERD.")
public class Autonomous extends LinearOpMode {

    @Override
    public void runOpMode() {
      
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
      /*    
          
          */

          forwardAndBackward("f");
          sleep(1000);
          reset();
          sideways("l");
          sleep(1000);
          reset();
          forwardAndBackward("f");
          sleep(1000);
          reset();
          
          
          }
        }
     }
