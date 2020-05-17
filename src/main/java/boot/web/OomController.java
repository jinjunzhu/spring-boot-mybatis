package boot.web;

import boot.DeadLock;
import boot.oom.ArraySizeExceeds;
import boot.oom.CreateNativeThreads;
import boot.oom.GcOverrhead;
import boot.oom.HeapSize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oom")
public class OomController {

    @RequestMapping("/arraySizeExceeds")
    public String arraySizeExceeds(){
        ArraySizeExceeds.test();
        return "Sucess!";
    }

    @RequestMapping("/createNativeThreads")
    public String createNativeThreads(){
        System.out.println("createNativeThreads test");
        CreateNativeThreads.test();
        return "Sucess!";
    }

    @RequestMapping("/createNativeThreads1")
    public String createNativeThreads1(){
        System.out.println("createNativeThreads test1");
        CreateNativeThreads.test1();
        return "Sucess!";
    }

    @RequestMapping("/gcOverrhead")
    public String gcOverrhead(){
        GcOverrhead.test();
        return "Sucess!";
    }

    @RequestMapping("/heapSize")
    public String heapSize(){
        HeapSize.test();
        return "Sucess!";
    }

    @RequestMapping("/deadLock")
    public String deadLock(){
        DeadLock.test();
        return "Sucess!";
    }

}
