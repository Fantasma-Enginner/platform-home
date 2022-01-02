import { registerApplication, start } from "single-spa";
import {
  constructApplications,
  constructRoutes,
  constructLayoutEngine,
} from "single-spa-layout";


const options = {
  method: "GET"
};

var host = document.location.hostname;
var protocol = document.location.protocol;

fetch(protocol+'//'+host+':8760/platform-manager/api/v1/resources/layout', options)
  .then(function (response) {
    return response.json();
  }).then(function (props) {
    const routes = constructRoutes(
      props
    );
    const applications = constructApplications({
      routes,
      loadApp({ name }) {
        return System.import(name);
      },
    });
    const layoutEngine = constructLayoutEngine({ routes, applications });
    applications.forEach(registerApplication);
    layoutEngine.activate();
    start();
  });
