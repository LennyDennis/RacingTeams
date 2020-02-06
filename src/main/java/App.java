import models.Members;
import models.Teams;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        Map<String, Object> model = new HashMap<String, Object>();

        post("/",(req,res)->{
            String inputtedUsername = req.queryParams("username");
            req.session().attribute("username", inputtedUsername);
            model.put("username", inputtedUsername);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (req, res) -> {
            model.put("username", req.session().attribute("username"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/new",(req,res) ->{
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/new",(req,res)->{
            String name = req.queryParams("teamName");
            String advantage = req.queryParams("advantage");
            int maxsize = Integer.parseInt(req.queryParams("maxsize"));
            Teams team = new Teams(name,advantage,maxsize);
            return  new ModelAndView(model, "tsuccess.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams",(req,res)-> {
            model.put("teams",Teams.all());
            return new ModelAndView(model, "teams.hbs");
        },new HandlebarsTemplateEngine());

        get("/members/new",(req,res) ->{
            return new ModelAndView(model, "members-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/members/new",(req,res)->{
//            Teams theTeam = Teams.find(Integer.parseInt(req.queryParams("teamId")));
            String name = req.queryParams("memberName");
            int age = Integer.parseInt(req.queryParams("memberAge"));
            String memberAdv = req.queryParams("memberAdv");
            String weakness = req.queryParams("memberWeakness");
            String memberTeam = req.queryParams("memberTeam");
            Members member = new Members(name,age,memberAdv,weakness,memberTeam);
//            if (Teams.memberExistsInATeam(member)) {
//                String existAlert = "This member isnin a team";
//                model.put("alert", existAlert);
//            }else if (theTeam.getMembers().size() >= theTeam.getNumber()) {
//                String sizeAlert = "Team is already full!!!!";
//                model.put("sizeMet", sizeAlert);
//            }else{
//                theTeam.addMember(member);
//            }
            return  new ModelAndView(model, "msuccess.hbs");
        }, new HandlebarsTemplateEngine());

        get("/members",(req,res)-> {
            model.put("members",Members.all());
            return new ModelAndView(model, "members.hbs");
        },new HandlebarsTemplateEngine());


    }
}
