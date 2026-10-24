package com.mycompany.companytree;

public class CompanyTreeDriver {

    public static void main(String[] args) {

        // Create CEO
        GeneralTreeNode root = new GeneralTreeNode("CEO");

        // Create department heads
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales");
        GeneralTreeNode vpEngineering = new GeneralTreeNode("VP of Engineering");

        root.addChild(vpSales);
        root.addChild(vpEngineering);

        // Sales department
        GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA)");
        GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");

        vpSales.addChild(salesNA);
        vpSales.addChild(salesEU);

        // Engineering department
        GeneralTreeNode devLead = new GeneralTreeNode("Dev Team Lead");
        GeneralTreeNode qaLead = new GeneralTreeNode("QA Team Lead");

        vpEngineering.addChild(devLead);
        vpEngineering.addChild(qaLead);

        // Developers
        GeneralTreeNode developer1 = new GeneralTreeNode("Developer 1");
        GeneralTreeNode developer2 = new GeneralTreeNode("Developer 2");

        devLead.addChild(developer1);
        devLead.addChild(developer2);

        // Traversals
        System.out.println("--- Preorder Traversal (Company Hierarchy) ---");
        root.traversePreorder();

        System.out.println("\n--- Postorder Traversal (Staff Roll Call) ---");
        root.traversePostorder();
    }
}
